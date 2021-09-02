package api.models

data class Word (
    var id: Int? = null,
    var text: String? = null,
    var meanings: List<Meaning>,
)