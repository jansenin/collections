import HashcodeObject = UniqueElementProblem.UsingMap.UsingGenerics.UsingHashcode.HashcodeNumber;

const arr1: number[] = [
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

const arr2: [number, string][] = [
    [1, "1"],
    [2, "2"],
    [3, "3"],
    [2, "2"],
    [4, "1"],
    [1, "1"],
    [4, "4"],
    [3, "1"]
];

const arr3: HashcodeObject[] = arr1.map(
    (element: number) => new HashcodeObject(element)
);

function testSolution(solutionName: string, func: Function, ...arrays: any[]) {
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

testSolution(
    "First solution",
    UniqueElementProblem.FirstSolution.getUnique,
    arr1
);

testSolution(
    "Using Map and for number type only",
    UniqueElementProblem.UsingMap.NumberTypeSolution.getUnique,
    arr1
);

testSolution(
    "Generic solution using Map and .toString()",
    UniqueElementProblem.UsingMap.UsingGenerics.UsingToString.getUnique,
    arr1,
    arr2
);

testSolution(
    "Generic solution using Map and hashcode",
    UniqueElementProblem.UsingMap.UsingGenerics.UsingHashcode.getUnique,
    arr3
);

testSolution(
    "Generic solution using recursion",
    UniqueElementProblem.UsingMap.UsingGenerics.UsingRecursion.getUnique,
    arr1,
    arr2,
    arr3
);

console.log(typeof 1);
console.log(typeof "1");
console.log(typeof false);
console.log(typeof []);
console.log(typeof {});
console.log(typeof Symbol.for("1"));
console.log(typeof (() => 1));
console.log(typeof undefined);
console.log(typeof null);

let b: any = {
    a: 1,
    b: Symbol("1"),
    [Symbol("2")]: 1
};

for (let key in b) console.log(key);

console.log();
console.log();

let obj1: any = {
    first_name: "Bob",
    last_name: "Jones",

    email: "bob@gmail.com",

    address: {
        line_1: "1234 Main St",
        line_2: "Apt 413",
        city: "Los Angeles",
        state: "CA",
        zip: "90048"
    },

    logins: [
        { date: "10/22/2012", ip: "192.168.0.1" },
        { date: "10/21/2012", ip: "192.168.0.1" }
    ],

    photos: ["IMG-1985.jpg", "IMG-1987.jpg"]
};

let obj2: any = {
    last_name: "Jones",
    active: true,

    address: {
        line_1: "2143 South Main St",
        line_2: undefined
    },

    logins: { date: "10/23/2012", ip: "192.168.0.1" },

    photos: undefined
};

ObjectMergeProblem.merge(obj1, obj2);

console.log(obj1);
