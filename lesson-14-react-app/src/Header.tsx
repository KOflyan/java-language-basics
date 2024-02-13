type Props = {
    clicked: number
}

export const Header = (props: Props) => {
    let timesText = 'times'

    if (props.clicked === 1) {
        timesText = 'time'
    }

    return <h1>
        The button was clicked {props.clicked} {timesText}!
    </h1>
}