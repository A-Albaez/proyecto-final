
# Proyecto sobre Facturación, ventas e inventario

##### Trabaje en grupo.
##### Debe desarrollar un proyecto en JAVA + MYSQL

La Empresa EGPH, lo contrata a usted y su grupo de trabajo para realizarle un pequeño proyecto con tecnología JAVA, le solicita un sistema de Facturación e inventario.
Los resultados de la reunión arrojan los siguientes módulos:

**Módulo de Facturación, Modulo de Inventario, Modulo de Clientes, Modulo de Reportes**


## Caso de uso: Iniciar sesión
#### Nombre
Iniciar sesión  

#### Descripción
El caso de uso comienza cuando un usuario quiere acceder al sistema, para ello ingresa su mail y su contraseña. Luego el sistema verifica los datos e inicia sesión.

#### Precondiciones
El usuario debe estar registrado

#### Flujo de eventos principales
1. El usuario ingresa al sitio
2. El sistema pide al usuario los datos de inicio de sesión (mail y contraseña). 
3. El usuario ingresa los datos solicitados.
4. El sistema verifica los datos y procede a iniciar la sesión del usuario. 
5. Fin CU.

#### Flujo de eventos alternativos
##### Datos incorrectos
1. El sistema detecta que los datos ingresados son incorrectos.
2. Si el usuario tiene más de 3 intentos se bloquea el usuario y despliega Mensaje “Usuario Bloqueado Comuníquese con el administrador”, al momento de bloquear se envía un email indicando que su usuario está bloqueado , si lo intentos son menores a 3 se despliega el siguiente mensaje “Usuario o Contraseña incorrecta”.
3. Se retorna al paso 2 del flujo principal.


#### Postcondiciones 
Se inició sesión en el sistema.

#### Requerimientos especiales
No hay.


## Caso de uso: Registrar cliente
#### Nombre
Registrar usuario

#### Descripción
El caso de uso comienza cuando el administrador elige la opción de registrar Cliente. Para esto el sistema despliega un formulario el cual solicita el nombre del cliente, dirección, teléfono móvil, fecha de nacimiento se validando los datos, el sistema crea al cliente nuevo.

#### Precondiciones
No hay

#### Flujo de eventos principales
1. El administrador elige la opción crear cliente 
2. El sistema despliega un formulario, para registrar los datos 
3. El usuario ingresa los datos solicitados.
4. El sistema verifica los datos y procede crear el usuario. 
5. El sistema envía una notificando la creación del usuario 
6. Fin CU.


#### Flujo de eventos alternativos
##### Datos Inválidos. 
1. El sistema detecta que faltan datos en el formulario.
2. El sistema despliega un mensaje de datos faltantes 
3. Se retorna al paso 3 del flujo principal.

##### Usuario registrado
1. El sistema detecta que el usuario esta registrado
2. EL sistema despliega un usuario registrado 
3. Se retorna al paso 3 del flujo principal.

#### Postcondiciones
Se crea un usuario

#### Requerimientos especiales
No hay


## Caso de uso: Registrar producto
#### Nombre
Registrar producto

#### Descripción
El caso de uso comienza cuando el usuario elige la opción de registrar usuario. Para esto el sistema despliega un formulario el cual solicita el código del producto, nombre, cantidad disponible. el usuario confirma el envío del formulario, se validando los datos, el sistema crea el producto.

#### Precondiciones
No hay

#### Flujo de eventos principales
1. El usuario elige la opción crear Productos 
2. El sistema despliega un formulario, para registrar los datos 
3. El usuario ingresa los datos solicitados.
4. El sistema verifica los datos y procede crear el producto. 
5. Fin CU.


#### Flujo de eventos alternativos
##### Datos Inválidos. 
1. El sistema detecta que faltan datos en el formulario.
2. El sistema despliega un mensaje de datos faltantes 
3. Se retorna al paso 3 del flujo principal.

##### Producto registrado
1. El sistema detecta que el producto está registrado
2. EL sistema despliega un usuario registrado 
3. Se retorna al paso 3 del flujo principal.

#### Postcondiciones
Se crea producto

#### Requerimientos especiales
No hay
