package npc
import chisel3._
import chisel3.util._
import npc.helper.defs.Base._
import npc.helper.opcode._
import npc.units.iFetch._
import npc.units.iDecode._
import npc.units.exu._
import npc.units.lsu._
import npc.units.wbu._

class NPCIO extends Bundle {

}

class NPCDebugIO extends Bundle {

}

class NPC extends Module{
  val ioNPC = IO(new NPCIO)
  val ioNPCDebug = IO(new NPCDebugIO)


  // Pipeline Components
  val NPC_IFU = Module(new IFU)
  val NPC_IDU = Module(new IDU)
  val NPC_EXU = Module(new EXU)
  val NPC_LSU = Module(new LSU)
  val NPC_WBU = Module(new WBU)


  // Pipeline Registers

  // PC Register Maintain and Manipulation
  // PC start from h80000000
  val PC = RegInit(StartAddr)

  // jump or branch , PC will be updated by this value
  // if not jump or branch, PC will be updated by PC + InstSize
  // update when oMasterValid is true
  // TODO: Finish IDU
  PC := MuxCase(PC, Array(
   (PC === StartAddr) -> (PC + InstSize.U),
   (RegNext(NPC_IFU.ioInternal.oMasterValid) && NPC_IDU.ioInternal.oMasterValid && !NPC_IDU.ioInternel.oIsDecodingJump) -> (PC + InstSize.U),
   (NPC_IDU.ioInternal.oMasterValid && NPC_IDU.ioInternal.oIsDecodingJump) -> (NPC_IDU.ioInternal.oFeedbackNewPC),
  ))

  // GRP
  val GRP = Mem(RegSum, UInt(DataWidth.W))
  val GRP_Status = Mem(RegSum, Bool())

  // GRP_Status(NPC_IDU.ioInternal.)

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