"use strict";
var UniqueElementProblem;
(function (UniqueElementProblem) {
    let FirstSolution;
    (function (FirstSolution) {
        function contains(arr, element) {
            for (let i = 0; i < arr.length; i++) {
                if (arr[i] == element)
                    return true;
            }
            return false;
        }
        function getUnique(arr) {
            let result = [];
            arr.forEach(element => {
                if (!contains(result, element))
                    result.push(element);
            });
            return result;
        }
        FirstSolution.getUnique = getUnique;
    })(FirstSolution = UniqueElementProblem.FirstSolution || (UniqueElementProblem.FirstSolution = {}));
    let UsingMap;
    (function (UsingMap) {
        let NumberTypeSolution;
        (function (NumberTypeSolution) {
            function getUnique(arr) {
                const map = new Map(arr.map(val => [val, 1]));
                const result = [];
                for (let key of map.keys()) {
                    result.push(key);
                }
                return result;
            }
            NumberTypeSolution.getUnique = getUnique;
        })(NumberTypeSolution = UsingMap.NumberTypeSolution || (UsingMap.NumberTypeSolution = {}));
        let UsingGenerics;
        (function (UsingGenerics) {
            let UsingHashcode;
            (function (UsingHashcode) {
                class HashcodeNumber {
                    constructor(value) {
                        this.value = value;
                    }
                    hashcode() {
                        return this.value;
                    }
                    toString() {
                        console.log(1);
                        return `${this.value}`;
                    }
                }
                UsingHashcode.HashcodeNumber = HashcodeNumber;
                function getUnique(arr) {
                    const map = new Map(arr.map(val => [val.hashcode(), val]));
                    const result = [];
                    for (let value of map.values()) {
                        result.push(value);
                    }
                    return result;
                }
                UsingHashcode.getUnique = getUnique;
            })(UsingHashcode = UsingGenerics.UsingHashcode || (UsingGenerics.UsingHashcode = {}));
            let UsingToString;
            (function (UsingToString) {
                function getUnique(arr) {
                    const map = new Map(arr.map(val => [val.toString(), val]));
                    const result = [];
                    for (let value of map.values()) {
                        result.push(value);
                    }
                    return result;
                }
                UsingToString.getUnique = getUnique;
            })(UsingToString = UsingGenerics.UsingToString || (UsingGenerics.UsingToString = {}));
            let UsingRecursion;
            (function (UsingRecursion) {
                function compare(o1, o2) {
                    if (typeof o1 !== typeof o2)
                        return false;
                    switch (typeof o1) {
                        case "boolean":
                        case "number":
                        case "string": {
                            if (o1 !== o2)
                                return false;
                            break;
                        }
                        case "function": {
                            let func1 = o1;
                            let func2 = o2;
                            if (func1.toString() !== func2.toString())
                                return false;
                            break;
                        }
                        case "object": {
                            for (let key in o1) {
                                if (!compare(o1[key], o2[key]))
                                    return false;
                            }
                            for (let key in o2) {
                                if (typeof o1[key] !== typeof o2[key])
                                    return false;
                            }
                        }
                        case "symbol": {
                            return true;
                        }
                    }
                    return true;
                }
                function contains(arr, element) {
                    for (let i = 0; i < arr.length; i++) {
                        if (compare(arr[i], element))
                            return true;
                    }
                    return false;
                }
                function getUnique(arr) {
                    let result = [];
                    arr.forEach(element => {
                        if (!contains(result, element))
                            result.push(element);
                    });
                    return result;
                }
                UsingRecursion.getUnique = getUnique;
            })(UsingRecursion = UsingGenerics.UsingRecursion || (UsingGenerics.UsingRecursion = {}));
        })(UsingGenerics = UsingMap.UsingGenerics || (UsingMap.UsingGenerics = {}));
    })(UsingMap = UniqueElementProblem.UsingMap || (UniqueElementProblem.UsingMap = {}));
})(UniqueElementProblem || (UniqueElementProblem = {}));
