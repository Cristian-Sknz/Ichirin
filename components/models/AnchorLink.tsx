import Link, { LinkProps } from 'next/link'

interface AnchorLink extends LinkProps {
    children?: JSX.Element | JSX.Element[] | string;
}

export default function AnchorLink(props : AnchorLink) {
    return (
        <Link {...props}>
            <a>{props.children}</a>
        </Link>
    );
    
}