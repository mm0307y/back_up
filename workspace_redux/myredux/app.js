import { createStore } from "./redux0107.js";
import { reducer0107 } from "./redux0107.js";
import { increase, decrease, reset } from "./actions0107.js"

// createStore is not defind
const store = createStore(reducer0107); // 외부에서 사용하기 위해서 작성한다.

store.subscribe(() => {
  console.log(store.getState());
});

store.dispatcher(increase()); // increase괄호 안에 payload자리
store.dispatcher(increase());
store.dispatcher(decrease());
store.dispatcher(reset());