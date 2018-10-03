
public enum Tipo {
    ENTEROS("^\\d+$"),
    STRINGS("\"(.*?)\""),
    OP_ARIT("[* | / | + | - | ^ ]$"),
    OP_LOG("neji|sasori|deidara"),
    ASIGNACION("="),
    PALABRAS_RESERVADAS("(\n|Hokage|Byakugan|Sharingan|Rinnegan|Kamui)$"),
    IDENTIFICADORES("^_[A-Za-z|0-9]+$"),
    AGRUPADORES("[ { | } | \\[ | \\] | \\( | \\) ]$"),
    TERMINADORES("\\;"),
    FLOATS("[0-9]*[.][0.9]*");

    public final String patron;

    Tipo(String s) {
        this.patron = s;

    }
}
