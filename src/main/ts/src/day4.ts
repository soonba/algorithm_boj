import { promises as fs } from 'fs';

type Passport = {
  byr?: number;
  iyr?: number;
  eyr?: number;
  hgt?: string;
  hcl?: string;
  ecl?: string;
  pid?: string;
  cid?: string;
};

const passportRequiredFields: (keyof Passport)[] = [
  'iyr',
  'ecl',
  'byr',
  'hcl',
  'eyr',
  'hgt',
  'pid',
];
const numberTypeFields: (keyof Passport)[] = ['byr', 'eyr', 'iyr'];
const eyeColors = ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth'];

const loadInputs = async (path: string): Promise<string[][]> => {
  const input = (await fs.readFile(path, 'utf-8')).trimEnd();
  const split = input.split('\n\n');
  return split.map((el) => el.split('\n').flatMap((el) => el.split(' ')));
};

const toPassport = (input: string[]): Passport => {
  return input.reduce<Passport>((prev, curr) => {
    const [k, v] = curr.split(':');
    prev[k] = numberTypeFields.includes(k as keyof Passport) ? +v : v;
    return prev;
  }, {});
};

const isValidPassport = (passport: Passport) => {
  return passportRequiredFields.every((el) => el in passport);
};

const isValidYear = (target: number, minY: number, maxY: number) => {
  if (!target || target.toString().length !== 4) return false;
  return target >= minY && target <= maxY;
};

const isValidHeight = (target: string) => {
  if (!target) return false;
  const result = target.match(/^(\d+)(cm|in)$/);
  if (!result) return false;
  const [_, num, unit] = result;
  const value = +num;
  if (unit === 'cm' && !(value >= 150 && value <= 193)) return false;
  if (unit === 'in' && !(value >= 59 && value <= 76)) return false;
  return true;
};

const isValidHairColor = (hcl: string) => {
  if (!hcl) return false;
  return /^#[0-9a-f]{6}$/.test(hcl);
};

const isValidEyeColor = (ecl: string) => {
  if (!ecl) return false;
  return eyeColors.includes(ecl);
};

const isValidPid = (pid: string) => {
  if (!pid) return false;
  return /^[0-9]{9}$/.test(pid);
};

const isValidPart2 = (passport: Passport) => {
  if (!isValidYear(passport?.byr, 1920, 2002)) return false;
  if (!isValidYear(passport?.iyr, 2010, 2020)) return false;
  if (!isValidYear(passport?.eyr, 2020, 2030)) return false;
  if (!isValidHeight(passport?.hgt)) return false;
  if (!isValidHairColor(passport?.hcl)) return false;
  if (!isValidEyeColor(passport?.ecl)) return false;
  if (!isValidPid(passport?.pid)) return false;
  return true;
};

export const day4 = async () => {
  const inputs = await loadInputs(`./input/day4.txt`);
  const passports = inputs.map(toPassport);
  console.log(passports.filter(isValidPassport).length);
  console.log(passports.filter(isValidPart2).length);
};

day4();
