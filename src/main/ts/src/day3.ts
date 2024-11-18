import { promises as fs } from 'fs';

const loadInputs = async (path: string): Promise<string[][]> => {
  const input = await fs.readFile(path, 'utf-8');
  const split = input.split('\n');
  return split.map((el) => el.split(''));
};

const day3 = async () => {
  const inputs = await loadInputs(`./input/day3.txt`);
};

day3();
