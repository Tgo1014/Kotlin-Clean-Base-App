package base.data.local.mapper

interface Mapper<D, E> {
    fun toEntity(domain: D): E
    fun toDomain(entity: E): D
}