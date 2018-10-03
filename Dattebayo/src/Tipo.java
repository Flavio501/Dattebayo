
public enum Tipo {
    ENTEROS("^\\d+$"),
    STRINGS("\"(.*?)\""),
    OP_ARIT("[* | / | + | - | ^ ]$"),
    OP_LOG("neji|sasori|deidara|gui|lee|gaara|choji|hidan"),
    ASIGNACION("="),
    PALABRAS_RESERVADAS("(\n|Hokage|byakugan|sharingan|rinnegan|kamui|tsukuyomi|kurama|gyuki|genin|jonin)$"),
    IDENTIFICADORES("^_[A-Za-z|0-9]+$"),
    AGRUPADORES("[ { | } | \\[ | \\] | \\( | \\) ]$"),
    TERMINADORES("\\;"),
    TIPOS("chidori|rasengan|susanoo|chakra|shuriken"),
    FLOATS("[0-9]*[.][0.9]*");

    public final String patron;

    Tipo(String s) {
        this.patron = s;

    }
}
