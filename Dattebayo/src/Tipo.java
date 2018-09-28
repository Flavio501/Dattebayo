
public enum Tipo {
    ENTEROS("^\\d+$"),
    STRINGS("[A-Za-z*]+$"),
    OP_ARIT("[*|/|+|-|^]$"),
    OP_LOG("neji|sasori|deidara"),
    ASIGNACION("="),
    PALABRAS_RESERVADAS("(\n|abs|brk|cs|char|cl|do|else|extends|for|if|implements|import|infa|swt|this|try|wl|yes|no|bl|bt|st"
            + "str|int|ft|dou)$"),
    IDENTIFICADORES("^_[A-Za-z|0-9]+$"),
    AGRUPADORES("[{|}|[|]|(|)]$"),
    TERMINADORES(";");

    public final String patron;

    Tipo(String s) {
        this.patron = s;

    }
}
