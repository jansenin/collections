namespace UniqueElementProblem {
    export namespace FirstSolution {
        function contains(arr: number[], element: number): boolean {
            for (let i = 0; i < arr.length; i++) {
                if (arr[i] == element) return true;
            }
            return false;
        }

        export function getUnique(arr: number[]): number[] {
            let result: number[] = [];

            arr.forEach(element => {
                if (!contains(result, element)) result.push(element);
            });

            return result;
        }
    }

    export namespace UsingMap {
        export namespace NumberTypeSolution {
            export function getUnique(arr: number[]): number[] {
                const map = new Map<number, number>(arr.map(val => [val, 1]));

                const result: number[] = [];
                for (let key of map.keys()) {
                    result.push(key);
                }
                return result;
            }
        }

        export namespace UsingGenerics {
            export namespace UsingHashcode {
                export interface IHasHashcode {
                    hashcode: () => number;
                }

                export class HashcodeNumber
                    implements
                        UniqueElementProblem.UsingMap.UsingGenerics
                            .UsingHashcode.IHasHashcode {
                    constructor(public value: any) {}

                    hashcode(): number {
                        return this.value;
                    }

                    toString(): string {
                        console.log(1);
                        return `${this.value}`;
                    }
                }

                export function getUnique(arr: IHasHashcode[]): IHasHashcode[] {
                    const map = new Map<number, IHasHashcode>(
                        arr.map(val => [val.hashcode(), val])
                    );

                    const result: IHasHashcode[] = [];
                    for (let value of map.values()) {
                        result.push(value);
                    }
                    return result;
                }
            }

            export namespace UsingToString {
                export function getUnique<T extends any>(arr: T[]): any[] {
                    const map = new Map<string, T>(
                        arr.map(val => [val.toString(), val])
                    );

                    const result: T[] = [];
                    for (let value of map.values()) {
                        result.push(value);
                    }
                    return result;
                }
            }

            export namespace UsingRecursion {
                function compare(o1: any, o2: any): boolean {
                    if (typeof o1 !== typeof o2) return false;

                    switch (typeof o1) {
                        case "boolean":
                        case "number":
                        case "string": {
                            if (o1 !== o2) return false;
                            break;
                        }

                        case "function": {
                            let func1: Function = o1 as Function;
                            let func2: Function = o2 as Function;
                            if (func1.toString() !== func2.toString())
                                return false;
                            break;
                        }

                        case "object": {
                            for (let key in o1) {
                                if (!compare(o1[key], o2[key])) return false;
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

                function contains(arr: any[], element: any): boolean {
                    for (let i = 0; i < arr.length; i++) {
                        if (compare(arr[i], element)) return true;
                    }
                    return false;
                }

                export function getUnique(arr: any[]): any[] {
                    let result: any[] = [];

                    arr.forEach(element => {
                        if (!contains(result, element)) result.push(element);
                    });

                    return result;
                }
            }
        }
    }
}
