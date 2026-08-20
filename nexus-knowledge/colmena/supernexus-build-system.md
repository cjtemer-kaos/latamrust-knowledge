# supernexus-build-system

Build SuperNEXUS UI: build-safe.sh compila desde ui/src/ con vite. Los archivos estáticos (ninjas/, kaos.png) deben estar en ui/public/ para que vite los copie a dist/. Si falta una imagen en dist, copiarla de dist_golden/ a public/. Regex en build-safe.sh: index-[A-Za-z0-9_-]+ (captura guiones). Golden bundle es 1.4MB, source compilado ~548KB.
