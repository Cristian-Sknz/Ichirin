export function removeAccents(text : string) : string {
    return text.normalize('NFD').replace(/[\u0300-\u036f]/g, "");
}

export function textLimiter(text: string, size: number) {
    if (text.length > size){
      return `${text.substring(0, size)}...`;
    }
    return text;
}


/**  
 * Aqui contém replaces de varios caracteres,
 * acentos serão removidos com o metodo removeAccents()
 * caracteres asiaticos serão removidos com (/[^\x00-\x7F]/g)
 * caracteres especiais serão removidos com (/[^A-Z0-9]+/ig)
 * espaços serão repostos por '-' com / /g
*/
export function convertNameToUrl(name : string) {
  return removeAccents(name.replace(/[^\x00-\x7F]/g, '').trim())
    .replace(/[^A-Z0-9]+/ig, ' ').trim().replace(/ /g, '-');
}