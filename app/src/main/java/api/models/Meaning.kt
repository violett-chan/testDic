package api.models

data class Meaning (
    var id: Int? = null,
    var partOfSpeechCode: String? = null,
    var translation: Translation,
    var previewUrl: String? = null,
    var imageUrl: String? = null,
    var transcription: String? = null,
    var soundUrl: String? = null,
)