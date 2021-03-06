package base.presentation.mappers

interface Mapper<D, P> {
    fun toPresentation(domain: D): P
    fun toDomain(presentation: P): D
}