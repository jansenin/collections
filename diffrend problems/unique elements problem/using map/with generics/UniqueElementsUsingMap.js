"use strict";
let arr = [
    [1, "1"],
    [2, "2"],
    [3, "3"],
    [2, "2"],
    [4, "1"],
    [1, "1"],
    [4, "4"],
    [3, "1"]
];
/*let arr: T[] = [
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
];*/
function getUnique(arr) {
    let i = 1;
    let map = new Map(arr.map(val => [val, i++]));
    console.log(map);
    console.log(map.get([1, "1"]));
    let result = [];
    for (let key of map.keys()) {
        result.push(key);
    }
    return result;
}
console.log(arr);
console.log(getUnique(arr));
