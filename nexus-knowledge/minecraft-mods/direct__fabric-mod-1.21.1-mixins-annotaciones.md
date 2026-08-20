# Direct: fabric-mod-1.21.1-mixins-annotaciones

Category: Minecraft-mods
Tags: direct-learned
Created: 2026-08-20T13:26:11.715240

---

Anotaciones de Mixin en 1.21.1: @Inject(method="...", at=@At(...)) con injection points HEAD, RETURN, INVOKE, TAIL; handler void con CallbackInfo (o CallbackInfoReturnable con setReturnValue si el target retorna valor) y attribute cancellable=true para cancelar con ci.cancel(). @Mixin(targets="pkg.Outer$Inner", remap=false) para clases privadas/anidadas o no remapeadas. Accessors son interfaces anotadas @Mixin con @Accessor (getters/setters) e @Invoker (llamar metodo privado); setters de campos final requieren @Mutable; los metodos se prefixean con modid$ para evitar colisiones. Los targets usan JVM descriptors (ej method='<init>()V'). Existen tambien @ModifyArg, @Redirect, etc. via Mixin y MixinExtras.
