var arr = [
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
function getUnique(arr) {
    let map = new Map(arr);

    for (let i = 0; i < arr.length; i++) {
        map.set(arr[i], 1);
    }

    let result = [];
    for (let key of map.keys()) {
        result.push(key);
    }
    return result;
}
console.log(arr);
console.log(getUnique(arr));