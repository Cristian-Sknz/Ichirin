import Link, { LinkProps } from 'next/link'

interface AnchorLink extends LinkProps {
    className?: string;
    children?: JSX.Element | JSX.Element[] | any;
}

export default function AnchorLink(props : AnchorLink) {
    return (
        <Link {...props} prefetch={false}>
            <a className={props.className}>{props.children}</a>
        </Link>
    );
    
}