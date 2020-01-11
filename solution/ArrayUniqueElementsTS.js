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
function contains(arr, element) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == element)
            return true;
    }
    return false;
}
function getUnique(arr) {
    var result = [];
    arr.forEach(function (element) {
        if (!contains(result, element))
            result.push(element);
    });
    return result;
}
console.log(arr);
console.log(getUnique(arr));
