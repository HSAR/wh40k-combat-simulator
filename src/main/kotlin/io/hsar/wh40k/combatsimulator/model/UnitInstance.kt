package io.hsar.wh40k.combatsimulator.model

import io.hsar.wh40k.combatsimulator.logic.TacticalActionStrategy
import io.hsar.wh40k.combatsimulator.logic.TurnAction
import io.hsar.wh40k.combatsimulator.model.unit.Attribute
import io.hsar.wh40k.combatsimulator.model.unit.AttributeValue
import io.hsar.wh40k.combatsimulator.model.unit.EquipmentInfo
import io.hsar.wh40k.combatsimulator.model.unit.EquipmentType
import io.hsar.wh40k.combatsimulator.model.unit.Unit

/**
 * A single combatant.
 * This class may contain dynamic information that changes as combat progresses.
 */
class UnitInstance(
        val name: String,  // #TODO how is this different from the name member variable of unit?
        val description: String,
        val unit: Unit,
        val equipment: Map<EquipmentType, EquipmentInfo>,
        val attributes: Map<Attribute, AttributeValue>, // #TODO: Figure out whether this is good long-term solution
        val tacticalActionStrategy: TacticalActionStrategy = TacticalActionStrategy
) {

    fun executeTurnAction(turnAction: TurnAction) {
        TODO("Not yet implemented")
    }
}