import Link, { LinkProps } from 'next/link'

interface ALinkProps extends LinkProps {
    children?: JSX.Element | JSX.Element[] | string;
}

export default function ALink(props : ALinkProps) {
    return (
        <Link {...props}>
            <a>{props.children}</a>
        </Link>
    );
    
}