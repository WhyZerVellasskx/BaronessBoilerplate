package io.github.blackbaroness.boilerplate.configurate.serializer

import io.github.blackbaroness.boilerplate.adventure.parseMiniMessage
import io.github.blackbaroness.boilerplate.configurate.type.MiniMessageComponent
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

class MiniMessageComponentSerializer : TypeSerializer<MiniMessageComponent> {

    override fun deserialize(type: Type, node: ConfigurationNode): MiniMessageComponent? {
        return node.string?.let { MiniMessageComponent(it, it.parseMiniMessage()) }
    }

    override fun serialize(type: Type, obj: MiniMessageComponent?, node: ConfigurationNode) {
        if (obj == null) {
            node.raw(null)
            return
        }

        node.set(obj.originalString)
    }
}
