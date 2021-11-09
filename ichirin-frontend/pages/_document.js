import Document, { Html, Head, Main, NextScript } from 'next/document'

class IchrinDocument extends Document {
  static async getInitialProps(ctx) {
    const initialProps = await Document.getInitialProps(ctx);
    return { ...initialProps };
  }

  render() {
    return (
      <Html lang={'pt-br'}>
        <Head>
          <meta
            name='description'
            content='Ichirin no Hana Yuri - Mangas Yuri'
          />
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

export default IchrinDocument;
