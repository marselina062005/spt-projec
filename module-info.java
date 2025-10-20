module doc.core {
    exports doc.core; // Supaya bisa dipakai modul 
    module doc.html {
    requires doc.core;
    provides doc.core.DocumentProcessor with doc.html.HtmlProcessor;
}
package doc.html;

import doc.core.DocumentProcessor;

public class HtmlProcessor implements DocumentProcessor {

    @Override
    public String process(String content) {
        // Contoh sederhana: bungkus isi HTML ke dalam <div>
        return "HtmlProcessor result:\n" +
               "<div class='rendered-html'>\n" +
               content + "\n</div>";
    }

    @Override
    public String getFormatName() {
        return "HTML";
    }
}javac --module-path out -d out/doc.html $(find doc.html/src -name "*.java")