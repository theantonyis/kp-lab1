import java.time.LocalDate

data class Patient(
    val id: Int,
    val name: String,
    val dateOfBirth: LocalDate,
    val phoneNumber: String?, // Nullable
    val medicalHistory: String?
)