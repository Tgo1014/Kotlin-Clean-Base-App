package base.data.remote.mappers

interface Mapper<in R, out M> {
    fun parse(remote: R): M
}