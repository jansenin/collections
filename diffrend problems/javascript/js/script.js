"use strict";
var HashcodeObject = UniqueElementProblem.UsingMap.UsingGenerics.UsingHashcode.HashcodeNumber;
const arr1 = [
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
const arr2 = [
    [1, "1"],
    [2, "2"],
    [3, "3"],
    [2, "2"],
    [4, "1"],
    [1, "1"],
    [4, "4"],
    [3, "1"]
];
const arr3 = arr1.map((element) => new HashcodeObject(element));
function testSolution(solutionName, func, ...arrays) {
    console.log("------------------");
    console.log(solutionName, " :");
    for (let array of arrays) {
        console.log("-");
        console.log("   Array: ", array);
        console.log("   Processed array: ", func(array));
        console.log("-");
    }
    console.log("------------------");
}
testSolution("First solution", UniqueElementProblem.FirstSolution.getUnique, arr1);
testSolution("Using Map and for number type only", UniqueElementProblem.UsingMap.NumberTypeSolution.getUnique, arr1);
testSolution("Generic solution using Map and .toString()", UniqueElementProblem.UsingMap.UsingGenerics.UsingToString.getUnique, arr1, arr2);
testSolution("Generic solution using Map and hashcode", UniqueElementProblem.UsingMap.UsingGenerics.UsingHashcode.getUnique, arr3);
testSolution("Generic solution using recursion", UniqueElementProblem.UsingMap.UsingGenerics.UsingRecursion.getUnique, arr1, arr2, arr3);
console.log(typeof 1);
console.log(typeof "1");
console.log(typeof false);
console.log(typeof []);
console.log(typeof {});
console.log(typeof Symbol.for("1"));
console.log(typeof (() => 1));
console.log(typeof undefined);
console.log(typeof null);
let b = {
    a: 1,
    b: Symbol("1"),
    [Symbol("2")]: 1
};
for (let key in b)
    console.log(key);
