  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 5
          # Emitting i0
          subl $4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = 4
          # Emitting i1
          subl $4, %esp
          # Emitting 4
          movl $4, %esi
        movl %esi, -8(%ebp)
        # Emitting i1 = (i1 / (i1 + 4))
          # Emitting i1
          movl -8(%ebp), %edi
          # Emitting (i1 / (i1 + 4))
            # Emitting i1
            movl -8(%ebp), %esi
          pushl %esi
            # Emitting (i1 + 4)
              # Emitting i1
              movl -8(%ebp), %esi
            pushl %esi
              # Emitting 4
              movl $4, %esi
            movl -16(%ebp), %edx
            addl $4, %esp
            addl %esi, %edx
          movl -12(%ebp), %esi
          addl $4, %esp
          cmpl $0, %edx
          pushl %eax
          movl %esi, %eax
          cltd
          idivl %edx
          movl %eax, %esi
          addl $4, %esp
        movl %esi, -8(%ebp)
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
