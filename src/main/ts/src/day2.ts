import { promises as fs } from 'fs';

type Datum = {
  lNum: number;
  rNum: number;
  target: string;
  pw: string;
};
const loadInputs = async (path: string): Promise<string[]> => {
  const input = await fs.readFile(path, 'utf-8');
  const split = input.split('\n');
  split.pop();
  return split;
};

const parseToDatum = (input: string): Datum => {
  //3-11 z: zzzzzdzzzzlzz
  const [meta, pw] = input.split(':');
  const [bound, target] = meta.split(' ');
  const [lNum, rNum] = bound.split('-');
  return { lNum: +lNum, rNum: +rNum, pw, target };
};

const calcPart1 = (acc: number, { lNum, rNum, pw, target }: Datum) => {
  let count = 0;
  for (let i = 1; i < pw.length; i++) {
    if (pw.charAt(i) === target) {
      if (++count > rNum) {
        return acc;
      }
    }
  }
  return count >= lNum ? ++acc : acc;
};

const calcPart2 = (acc: number, { lNum, rNum, pw, target }: Datum) => {
  let count = 0;
  count += pw.charAt(lNum) === target ? 1 : -1;
  count += pw.charAt(rNum) === target ? 1 : -1;
  return count === 0 ? ++acc : acc;
};

const day2 = async () => {
  const inputs = await loadInputs(`./input/day2.txt`);
  const data = inputs.map<Datum>(parseToDatum);
  const result1 = data.reduce(calcPart1, 0);
  const result2 = data.reduce(calcPart2, 0);
  console.log(result1);
  console.log(result2);
};

day2();
