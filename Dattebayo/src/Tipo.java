
public enum Tipo {
    ENTEROS("^\\d+$"),
    STRINGS("\"(.*?)\""),
    OP_ARIT("[* | / | + | - | ^ ]$"),
    OP_LOG("Neji|Sasori|Deidara|Gui|Lee|Gaara|Choji|Hidan"),
    ASIGNACION("="),
    PALABRAS_RESERVADAS("(\n|Hokage|Byakugan|Sharingan|Rinnegan|Kamui|Tsukuyomi|Kurama|Gyuki|Genin|Jonin)$"),
    IDENTIFICADORES("^_[A-Za-z|0-9]+$"),
    AGRUPADORES("[{|}|[|]|(|)]$"),
    TERMINADORES("(;)"),
    TIPOS("Chidori|Rasengan|Susanoo|Chakra|Shuriken"),
    FLOATS("[0-9]*[.][0.9]*");

    public final String patron;

    Tipo(String s) {
        this.patron = s;

    }
}
