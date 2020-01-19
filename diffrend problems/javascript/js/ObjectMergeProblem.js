"use strict";
var ObjectMergeProblem;
(function (ObjectMergeProblem) {
    function merge(obj1, obj2) {
        for (let key in obj1) {
            if (Array.isArray(obj1[key])) {
                if (obj2[key] !== undefined && !Array.isArray(obj2[key])) {
                    obj1[key].push(obj2[key]);
                }
                else if (obj2.hasOwnProperty(key) &&
                    (obj2[key] === undefined || obj2[key] === null)) {
                    obj1[key] = [];
                }
                else if (Array.isArray(obj2[key])) {
                    obj1[key] == obj2[key];
                }
            }
            else if (obj1.hasOwnProperty(key) &&
                obj2.hasOwnProperty(key) &&
                obj2[key] === undefined) {
                delete obj1[key];
            }
            else if (typeof obj1[key] === "object" &&
                typeof obj2[key] === "object") {
                merge(obj1[key], obj2[key]);
            }
        }
        for (let key in obj2) {
            let obj2ValueType = typeof obj2[key];
            if (obj2ValueType === "bigint" ||
                obj2ValueType === "boolean" ||
                obj2ValueType === "number" ||
                obj2ValueType === "string") {
                obj1[key] = obj2[key];
            }
        }
    }
    ObjectMergeProblem.merge = merge;
})(ObjectMergeProblem || (ObjectMergeProblem = {}));
