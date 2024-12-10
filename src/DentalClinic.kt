import java.time.LocalDate

class DentalClinic {
    private val patients = mutableListOf<Patient>()
    private val dentists = mutableListOf<Dentist>()
    private val appointments = mutableListOf<Appointment>()

    // Додати пацієнта
    fun addPatient(patient: Patient) {
        patients.add(patient)
    }

    // Додати лікаря
    fun addDentist(dentist: Dentist) {
        dentists.add(dentist)
    }

    // Додати прийом
    fun addAppointment(appointment: Appointment) {
        appointments.add(appointment)
    }

    // Знайти пацієнтів за ім'ям
    fun findPatientsByName(name: String): List<Patient> {
        return patients.filter { it.name.contains(name, ignoreCase = true) }
    }

    // Отримати прийоми лікаря
    fun getAppointmentsByDentist(dentistId: Int): List<Appointment> {
        return appointments.filter { it.dentist.id == dentistId }
    }

    // Вивести список пацієнтів
    fun printPatients() {
        patients.forEach {
            println("ID: ${it.id}, Name: ${it.name}, DOB: ${it.dateOfBirth}, Phone: ${it.phoneNumber ?: "N/A"}")
        }
    }

    // Вивести список прийомів
    fun printAppointments() {
        appointments.forEach {
            println(
                "Appointment ID: ${it.id}, Patient: ${it.patient.name}, Dentist: ${it.dentist.name}, Date: ${it.date}, Notes: ${it.notes ?: "N/A"}"
            )
        }
    }
}

fun main() {
    val clinic = DentalClinic()

    // Додавання пацієнтів
    clinic.addPatient(Patient(1, "John Doe", LocalDate.of(1985, 6, 15), "123-456-7890", "No known allergies"))
    clinic.addPatient(Patient(2, "Jane Smith", LocalDate.of(1990, 12, 5), null, "Diabetic"))

    // Додавання лікарів
    clinic.addDentist(Dentist(1, "Dr. Emily Brown", "Orthodontist"))
    clinic.addDentist(Dentist(2, "Dr. Michael Green", "Endodontist"))

    // Додавання прийомів
    clinic.addAppointment(
        Appointment(
            1,
            clinic.findPatientsByName("John")[0],
            clinic.getAppointmentsByDentist(1).firstOrNull()?.dentist ?: Dentist(1, "Dr. Emily Brown", "Orthodontist"),
            LocalDate.of(2024, 12, 20),
            "Routine check-up"
        )
    )

    clinic.addAppointment(
        Appointment(
            2,
            clinic.findPatientsByName("Jane")[0],
            clinic.getAppointmentsByDentist(2).firstOrNull()?.dentist ?: Dentist(2, "Dr. Michael Green", "Endodontist"),
            LocalDate.of(2024, 12, 22),
            "Root canal treatment"
        )
    )

    // Виведення даних
    println("\nPatients:")
    clinic.printPatients()

    println("\nAppointments:")
    clinic.printAppointments()
}
