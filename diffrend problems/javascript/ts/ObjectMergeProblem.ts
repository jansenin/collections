namespace ObjectMergeProblem {
    export function merge(obj1: any, obj2: any): any {
        for (let key in obj1) {
            if (Array.isArray(obj1[key])) {
                if (obj2[key] !== undefined && !Array.isArray(obj2[key])) {
                    (obj1[key] as Array<any>).push(obj2[key]);
                } else if (
                    (obj2 as Object).hasOwnProperty(key) &&
                    (obj2[key] === undefined || obj2[key] === null)
                ) {
                    obj1[key] = [];
                } else if (Array.isArray(obj2[key])) {
                    obj1[key] == obj2[key];
                }
            } else if (
                (obj1 as Object).hasOwnProperty(key) &&
                (obj2 as Object).hasOwnProperty(key) &&
                obj2[key] === undefined
            ) {
                delete obj1[key];
            } else if (
                typeof obj1[key] === "object" &&
                typeof obj2[key] === "object"
            ) {
                merge(obj1[key], obj2[key]);
            }
        }

        for (let key in obj2) {
            let obj2ValueType: string = typeof obj2[key];
            if (
                obj2ValueType === "bigint" ||
                obj2ValueType === "boolean" ||
                obj2ValueType === "number" ||
                obj2ValueType === "string"
            ) {
                obj1[key] = obj2[key];
            }
        }
    }
}
