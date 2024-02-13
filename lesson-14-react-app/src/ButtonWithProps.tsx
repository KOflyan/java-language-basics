type Props = {
    setClicked: () => void
}

export const ButtonWithProps = (props: Props) => {
    return <button
        onClick={props.setClicked}
    >
        Click me!
    </button>
}
