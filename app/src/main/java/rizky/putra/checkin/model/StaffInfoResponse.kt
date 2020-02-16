package rizky.putra.checkin.model

import com.google.gson.annotations.SerializedName


data class StaffInfoResponse (

    @SerializedName("id") val id : Int,
    @SerializedName("created_date") val created_date : String,
    @SerializedName("modified_date") val modified_date : String,
    @SerializedName("status") val status : String,
    @SerializedName("uid") val uid : Int,
    @SerializedName("title") val title : String,
    @SerializedName("cover_image") val cover_image : String,
    @SerializedName("description") val description : String,
    @SerializedName("wage_amount") val wage_amount : Double,
    @SerializedName("wage_type") val wage_type : String,
    @SerializedName("staff_required") val staff_required : Int,
    @SerializedName("timezone") val timezone : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("min_age") val min_age : Int,
    @SerializedName("max_age") val max_age : Int,
    @SerializedName("require_experience") val require_experience : Boolean,
    @SerializedName("require_english") val require_english : Boolean,
    @SerializedName("interview_time") val interview_time : String,
    @SerializedName("interview_info") val interview_info : String,
    @SerializedName("offer_statistics") val offer_statistics : Offer_statistics,
    @SerializedName("offer_counts") val offer_counts : Offer_counts,
    @SerializedName("application_counts") val application_counts : Application_counts,
    @SerializedName("employment_counts") val employment_counts : Employment_counts,
    @SerializedName("start_time") val start_time : String,
    @SerializedName("end_time") val end_time : String,
    @SerializedName("fixed_location") val fixed_location : Boolean,
    @SerializedName("schedules") val schedules : List<Schedules>,
    @SerializedName("client") val client : Client,
    @SerializedName("location") val location : Location,
    @SerializedName("position") val position : Position,
    @SerializedName("manager") val manager : Manager
)

data class Address (

    @SerializedName("id") val id : Int,
    @SerializedName("country") val country : Country,
    @SerializedName("street_1") val street_1 : String,
    @SerializedName("street_2") val street_2 : String,
    @SerializedName("zip") val zip : Int,
    @SerializedName("province") val province : String,
    @SerializedName("latitude") val latitude : Double,
    @SerializedName("longitude") val longitude : Double,
    @SerializedName("point") val point : String,
    @SerializedName("area") val area : Area
)

data class Application_counts (

    @SerializedName("pending_onboarding") val pending_onboarding : Int,
    @SerializedName("applied") val applied : Int,
    @SerializedName("pending_contract") val pending_contract : Int,
    @SerializedName("rejected") val rejected : Int,
    @SerializedName("withdrawn") val withdrawn : Int,
    @SerializedName("hired") val hired : Int
)

data class Area (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("city") val city : City
)

data class City (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("timezone") val timezone : String,
    @SerializedName("country") val country : Country
)

data class Client (

    @SerializedName("id") val id : Int,
    @SerializedName("country") val country : Country,
    @SerializedName("name") val name : String,
    @SerializedName("status") val status : String,
    @SerializedName("logo") val logo : String,
    @SerializedName("tier") val tier : String,
    @SerializedName("website") val website : String,
    @SerializedName("description") val description : String
)

data class Country (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("code") val code : String,
    @SerializedName("currency_code") val currency_code : String,
    @SerializedName("dial_code") val dial_code : Int
)
data class Employment_counts (

    @SerializedName("active") val active : Int,
    @SerializedName("cancelled") val cancelled : Int,
    @SerializedName("ended") val ended : Int
)
data class Location (

    @SerializedName("created_date") val created_date : String,
    @SerializedName("modified_date") val modified_date : String,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("address") val address : Address
)
data class Manager (

    @SerializedName("id") val id : Int,
    @SerializedName("uuid") val uuid : String,
    @SerializedName("name") val name : String,
    @SerializedName("email") val email : String,
    @SerializedName("phone") val phone : String,
    @SerializedName("role") val role : String,
    @SerializedName("locations") val locations : List<String>
)

data class Offer_counts (

    @SerializedName("sent") val sent : Int,
    @SerializedName("viewed") val viewed : Int,
    @SerializedName("applied") val applied : Int,
    @SerializedName("pending_onboarding") val pending_onboarding : Int,
    @SerializedName("pending_contract") val pending_contract : Int,
    @SerializedName("confirmed") val confirmed : Int,
    @SerializedName("withdrawn") val withdrawn : Int,
    @SerializedName("rejected") val rejected : Int,
    @SerializedName("cancelled") val cancelled : Int,
    @SerializedName("no_show") val no_show : Int,
    @SerializedName("contract_ended") val contract_ended : Int
)
data class Offer_statistics (

    @SerializedName("sent") val sent : Int,
    @SerializedName("viewed") val viewed : Int,
    @SerializedName("applied") val applied : Int,
    @SerializedName("confirmed") val confirmed : Int
)

data class Position (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("active") val active : Boolean
)
data class Schedules (

    @SerializedName("id") val id : Int,
    @SerializedName("staff_request") val staff_request : Int,
    @SerializedName("recurrences") val recurrences : String,
    @SerializedName("start_date") val start_date : String,
    @SerializedName("start_time") val start_time : String,
    @SerializedName("end_time") val end_time : String,
    @SerializedName("duration") val duration : String
)