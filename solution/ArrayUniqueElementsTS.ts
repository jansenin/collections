let arr: number[] = [
  1,
  2,
  3,
  4,
  2,
  3,
  1,
  2,
  3,
  4,
  1,
  2,
  3,
  4,
  2,
  4,
  5,
  5,
  7,
  6,
  5,
  4,
  3
];

function contains(arr: number[], element: number): boolean {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] == element) return true;
  }
  return false;
}

function getUnique(arr: number[]) {
  let result: number[] = [];
  arr.forEach(element => {
    if (!contains(result, element)) result.push(element);
  });
  return result;
}

console.log(arr);
console.log(getUnique(arr));

/*
This is the best from google

  var items = [4,5,4,6,3,4,5,2,23,1,4,4,4]
  var uniqueItems = Array.from(new Set(items))
*/
