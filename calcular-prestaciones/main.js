const auxDeTransporte = 249095
const diasPagados = 30
const diasLaboradosAnio = 360

const trabajadores = [
    {
        nombre: "Maria",
        salario: 2000000,
        diaTrabajados: 6 * diasPagados,
        vacaciones: true
    },
    {
        nombre: "Juan",
        salario: 2000000 + auxDeTransporte,
        diaTrabajados: 8 * diasPagados,
        vacaciones: true
    },
    {
        nombre: "Pedro",
        salario: 5000000,
        diaTrabajados: 12 * diasPagados,
        vacaciones: false
    }
]

const calcularPrima = (salario, diasTrabajados, diasLaboradosAnio) => {
    return (salario) * diasTrabajados / diasLaboradosAnio
}

const calcularCesantias = (salario, diasTrabajados, diasLaboradosAnio) => {
    return (salario) * diasTrabajados / diasLaboradosAnio
}

const calcularInteresesDeCensatias = (cesantias, diasTrabajados, diasLaboradosAnio) => {
    return (cesantias * diasTrabajados) * 0.12 / diasLaboradosAnio
}

const calcularVacaciones = (salario, diasTrabajados, diasLaboradosAnio) => {
    return (salario * diasTrabajados) / 720
}

trabajadores.forEach(persona => {
    console.log(persona.nombre);
    const prima = calcularPrima(persona.salario, persona.diaTrabajados, diasLaboradosAnio)
    console.log("PRIMA", prima);
    const cesantias = calcularCesantias(persona.salario, persona.diaTrabajados, diasLaboradosAnio)
    console.log("Cesantias", cesantias);
    const interesesDeCesantias = calcularInteresesDeCensatias(cesantias, persona.diaTrabajados, diasLaboradosAnio)
    console.log("Intereses de cesantias", interesesDeCesantias);
    const vacaciones = calcularVacaciones(persona.salario, persona.diaTrabajados)
    console.log("Vacaciones", vacaciones);

    totalPrima = ((persona.diaTrabajados / diasPagados) % 12) === 1 ? prima * 2 : prima
    total = totalPrima + cesantias + interesesDeCesantias + (persona.vacaciones ? vacaciones : 0)
    console.log(total)
});
