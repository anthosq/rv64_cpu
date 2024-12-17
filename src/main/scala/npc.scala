package npc
import chisel3._
import chisel3.util._

import npc.helper.defs.Base._

import npc.helper.opcode._
import npc.units.iFetch._

class NPCIO extends Bundle {

}

class NPCDebugIO extends Bundle {

}

class NPC extends Module{
  val ioNPC = IO(new NPCIO)
  val ioNPCDebug = IO(new NPCDebugIO)

  // Pipeline Components
  val NPC_IFU = Module(new IFU)

  // Pipeline Registers

  // PC Maintain and Manipulation
  // PC start from h80000000
  val PC = RegInit("h80000000".U(AddrWidth.W))
  PC := MuxCase(PC, Array(
   (PC === "h80000000".U) -> (PC + InstSize.U),
    // TODO: Finish the rest of the cases
  ))

  // GRP

  // Top -> IFU

  // IFU <-> IDU

  // IFU <-> IO

  // IDU <-> EXU

  // IDU <-> Top

  // EXU <-> LSU

  // LSU <-> WBU

  // LSU <-> IO

  // WBU <-> Top

  // Debug connections

}