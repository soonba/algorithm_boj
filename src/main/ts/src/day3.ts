import { promises as fs } from 'fs';

const TREE = '#';
const SLOPES = [
  [1, 1],
  [3, 1],
  [5, 1],
  [7, 1],
  [1, 2],
];

const loadInputs = async (path: string): Promise<string[]> => {
  const input = (await fs.readFile(path, 'utf-8')).trimEnd();
  return input.split('\n');
};

const calculateHitTrees = (inputs: string[], dx: number, dy: number): number => {
  const len = inputs[0].length;
  let x = 0;
  let hit = 0;
  for (let y = 0; y < inputs.length; y += dy) {
    if (inputs[y][x % len] === TREE) hit++;
    x += dx;
  }
  return hit;
};

export const day3 = async () => {
  const inputs = await loadInputs(`./input/day3.txt`);
  const product = (acc: number, curr: number) => acc * curr;
  const total = SLOPES.map(([dx, dy]) => calculateHitTrees(inputs, dx, dy)).reduce(product, 1);
  console.log(total);
};
day3();
