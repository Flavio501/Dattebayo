
public enum Tipo {
    NUMERO("^\\d+$"),
    LETRAS("[A-Za-z*]+$"),
    OPERADOR_BINARIO("[*|/|+|-|=|<|>|%]$"),
    PALABRAS_RESERVADAS("(\n|abs|brk|cs|char|cl|do|else|extends|for|if|implements|import|infa|swt|this|try|wl|yes|no|bl|bt|st"
            + "str|int|ft|dou)$"),
    IDENTIFICADORES("^_[A-Za-z|0-9]+$"),
    SIMBOLO("[;|,|:|(|)|{|}|[|]|!|.|]$"),
    TERMINADORES(";");
	

    public final String patron;

    Tipo(String s) {
        this.patron = s;

    }
}
