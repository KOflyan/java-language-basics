import { useState } from "react";

export const Button = () => {
    const [clicked, setClicked] = useState(0);

    let timesText = 'times'

    if (clicked === 1) {
        timesText = 'time'
    }

    return <button
        onClick={() => setClicked(clicked + 1)}
    >
        Button was clicked {clicked} {timesText}!
    </button>
}
