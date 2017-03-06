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
        # Emitting i0 = 0
          # Emitting i0
          addl $-4, %esp
          # Emitting 0
          movl $0, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = 1
          # Emitting i1
          addl $-4, %esp
          # Emitting 1
          movl $1, %esi
        movl %esi, -8(%ebp)
        # Emitting i2 = 2
          # Emitting i2
          addl $-4, %esp
          # Emitting 2
          movl $2, %esi
        movl %esi, -12(%ebp)
        # Emitting i3 = 3
          # Emitting i3
          addl $-4, %esp
          # Emitting 3
          movl $3, %esi
        movl %esi, -16(%ebp)
        # Emitting i4 = 4
          # Emitting i4
          addl $-4, %esp
          # Emitting 4
          movl $4, %esi
        movl %esi, -20(%ebp)
        # Emitting i5 = 5
          # Emitting i5
          addl $-4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -24(%ebp)
        # Emitting i6 = 6
          # Emitting i6
          addl $-4, %esp
          # Emitting 6
          movl $6, %esi
        movl %esi, -28(%ebp)
        # Emitting i7 = 7
          # Emitting i7
          addl $-4, %esp
          # Emitting 7
          movl $7, %esi
        movl %esi, -32(%ebp)
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
