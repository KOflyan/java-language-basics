import React, {useState} from 'react';
import './App.css';
import {ButtonWithProps} from "./ButtonWithProps";
import {Header} from "./Header";

function App() {
    const [clicked, setClicked] = useState(0);

    return (
        <div className="App">
            {/*<MyComponent></MyComponent>*/}
            {/*<Button></Button>*/}
            {/*<Button></Button>*/}

          <Header clicked={clicked}></Header>
          <div>
            <ButtonWithProps setClicked={() => setClicked(clicked + 1)}></ButtonWithProps>
          </div>
        </div>
  );
}

export default App;

