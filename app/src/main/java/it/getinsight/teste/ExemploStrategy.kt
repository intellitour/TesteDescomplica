package it.getinsight.teste

interface TransportStrategy {
    fun transportMedium(): String
}

class Car: TransportStrategy {
    override fun transportMedium(): String {
        return "Rodoviário"
    }
}

class Train: TransportStrategy {
    override fun transportMedium(): String {
        return "Ferroviário"
    }
}

class Plane: TransportStrategy {
    override fun transportMedium(): String {
        return "Aéreo"
    }
}


class TourPackage(
        private val transportStrategy: TransportStrategy,
        private val hotel: String,
        private val destination: String
    ) {

    fun fetchPackageDetails(): String {
        val medium = transportStrategy.transportMedium()
        return "Pacote CVC para $destination com transporte $medium e hospedagem no hotel $hotel"
    }

}
