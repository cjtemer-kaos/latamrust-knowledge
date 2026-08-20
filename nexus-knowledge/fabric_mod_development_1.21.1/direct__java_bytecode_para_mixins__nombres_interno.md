# Direct: Java bytecode para mixins: nombres internos y descriptores

Category: Fabric mod development 1.21.1
Tags: direct-learned
Created: 2026-08-20T14:38:16.471183

---

Los mixins operan sobre bytecode Java. Nombres internos de clase: nombre cualificado con puntos reemplazados por barras (java/lang/Object); clases anidadas usan $ (pkg/Foo$Bar); clases anonimas usan numeros (pkg/Foo$1). Descriptores de tipo: Z=boolean B=byte C=char D=double F=float I=int J=long S=short V=void; array = [ + tipo elemento (int[] -> [I); objeto = L + nombre interno + ; (String -> Ljava/lang/String;). Descriptor de metodo concatena parametros y retorno, ej. void drawText(int,int,String,int) -> (IILjava/lang/String;I)V. Constructores se llaman <init> y el bloque static <clinit>, ambos con retorno V. Fuente: docs.fabricmc.net/develop/mixins/bytecode.
