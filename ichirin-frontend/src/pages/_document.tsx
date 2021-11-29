import Document, { Html, Head, Main, NextScript } from 'next/document'
import { ServerStyleSheet } from 'styled-components'

class MyDocument extends Document {
  static async getInitialProps(ctx) {
    const sheet = new ServerStyleSheet()
    const originalRenderPage = ctx.renderPage

    try {
      ctx.renderPage = () => 
        originalRenderPage({
          enhanceApp: App => props => 
            sheet.collectStyles(<App {...props} />)
        })

      const initialProps = await Document.getInitialProps(ctx)
      return {
        ...initialProps,
        styles: (
          <>
            {initialProps.styles}
            {sheet.getStyleElement()}
          </>
        )
      }
    } finally {
      sheet.seal()
    }
  }

  render() {
    return (
      <Html lang={'pt-br'}>
        <Head>
          <meta
            name='description'
            content='Ichirin no Hana Yuri - Mangas Yuri'
          />
          <link rel="preconnect" href="https://fonts.googleapis.com"/>
          <link rel="preconnect" href="https://fonts.gstatic.com" crossOrigin={'true'}/>
          <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;300;400;500;600;700&family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"/>
          <link rel='icon' href='/favicon.svg' />
        </Head>
        <body>
          <Main/>
          <NextScript />
        </body>
      </Html>
    );
  }
}
export default MyDocument;