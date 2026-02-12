
---

# 📦 Sistema de Gestión Logística - Logitech Soluciones

## 📖 Descripción del Proyecto

La empresa **Logitech Soluciones** enfrenta problemas en sus procesos de inventario y despacho, ya que actualmente los registros se realizan de forma manual, generando desorden e inconsistencias en la información.

El departamento de desarrollo ha solicitado la creación de un **Sistema de Gestión Logística** desarrollado en **Java**, aplicando los principios de **Programación Orientada a Objetos (POO)**.

El sistema estará enfocado exclusivamente en la **lógica del negocio**, sin necesidad de interfaces gráficas.

---

## 🎯 Objetivo

Desarrollar un sistema que permita organizar, controlar y optimizar los procesos de:

* Gestión de productos
* Gestión de proveedores
* Gestión de órdenes de despacho
* Generación de reportes

---

## 🏗️ Arquitectura

El sistema será desarrollado utilizando:

* ☕ **Java**
* 🧱 **Programación Orientada a Objetos (POO)**
* 🔎 Enfoque exclusivo en la **lógica del negocio**
* ❌ Sin interfaz gráfica (sin GUI)

---

# 📂 Módulos del Sistema

## 1️⃣ Gestión de Productos

Permite administrar los productos del inventario.

### 📌 Cada producto debe tener:

* Código único
* Nombre
* Categoría
* Precio unitario
* Cantidad disponible en inventario

### ⚙️ Funcionalidades:

* Registrar nuevos productos
* Actualizar existencias
* Validar que no se puedan realizar despachos sin stock suficiente
* Consultar productos con bajo nivel de inventario

---

## 2️⃣ Gestión de Proveedores

Permite administrar la información de los proveedores.

### 📌 Cada proveedor debe tener:

* Nombre
* NIT
* Teléfono
* Lista de productos suministrados

### ⚙️ Funcionalidades:

* Asociar productos a proveedores
* Registrar órdenes de compra para reposición de inventario

---

## 3️⃣ Gestión de Órdenes de Despacho

Permite administrar el proceso de despacho de productos.

### 📌 Cada orden de despacho debe incluir:

* Número de orden
* Fecha
* Lista de productos
* Cantidades solicitadas
* Estado:

  * Pendiente
  * Despachada
  * Cancelada

### ⚙️ Reglas del sistema:

* No se puede despachar una orden si algún producto no tiene stock suficiente.
* Al confirmar el despacho:

  * Se descuentan automáticamente las cantidades del inventario.
* Se debe calcular el valor total de la orden.

---

## 4️⃣ Reportes del Sistema

El sistema debe generar los siguientes reportes:

* 📉 Listado de productos con inventario bajo
* 📜 Historial de órdenes despachadas
* 💰 Valor total de las ventas realizadas en un período
* 🏆 Producto más vendido

---

# 📊 Reglas de Negocio Importantes

* No se permiten despachos con stock insuficiente.
* El inventario debe actualizarse automáticamente al confirmar un despacho.
* Todos los productos deben tener un código único.
* Las órdenes deben manejar estados correctamente.

---

# 🚀 Alcance del Proyecto

Este sistema se enfoca exclusivamente en la **lógica interna del negocio**, por lo tanto:

* No incluye interfaz gráfica.
* No incluye base de datos obligatoria (puede manejarse en memoria).
* Puede ejecutarse desde consola.

---

# 👨‍💻 Autor

Proyecto desarrollado como solución académica para la empresa **Logitech Soluciones**.

---