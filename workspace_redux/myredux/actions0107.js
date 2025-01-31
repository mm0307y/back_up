import { DECREASE, INCREASE, RESET } from "./action-typs0107.js";
import { actionCreator } from "./redux0107.js";

export const increase = actionCreator(INCREASE);
export const decrease = actionCreator(DECREASE);
export const reset = actionCreator(RESET);
