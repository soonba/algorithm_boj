import { promises as fs } from 'fs';

const TREE = '#';

const loadInputs = async (path: string): Promise<string[]> => {
  const input = (await fs.readFile(path, 'utf-8')).trimEnd();
  return input.split('\n');
};

const calculateHitTrees = (inputs: string[], xDiff: number, yDiff: number) => {
  const maxIdx = inputs[0].length;
  let x = 0;
  let count = 0;
  for (let y = 0; y < inputs.length; y += yDiff) {
    if (inputs[y][x % maxIdx] === TREE) count++;
    x += xDiff;
  }
  return count;
};

export const day3 = async () => {
  const inputs = await loadInputs(`./input/day3.txt`);
  const slopes = [
    [1, 1],
    [3, 1],
    [5, 1],
    [7, 1],
    [1, 2],
  ];
  const total = slopes
    .map(([x, y]) => calculateHitTrees(inputs, x, y))
    .reduce((acc, curr) => acc * curr, 1);
  console.log(total);
};

day3();
