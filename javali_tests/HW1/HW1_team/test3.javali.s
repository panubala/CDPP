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
        # Emitting write((1 + (2 * 3)))
          # Emitting (1 + (2 * 3))
            # Emitting (2 * 3)
              # Emitting 2
              movl $2, %edi
              # Emitting 3
              movl $3, %esi
            imull %esi, %edi
            # Emitting 1
            movl $1, %esi
          addl %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(((1 + 2) * 3))
          # Emitting ((1 + 2) * 3)
            # Emitting (1 + 2)
              # Emitting 1
              movl $1, %esi
              # Emitting 2
              movl $2, %edi
            addl %edi, %esi
            # Emitting 3
            movl $3, %edi
          imull %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 + (2 * 3)))
          # Emitting (1 + (2 * 3))
            # Emitting (2 * 3)
              # Emitting 2
              movl $2, %esi
              # Emitting 3
              movl $3, %edi
            imull %edi, %esi
            # Emitting 1
            movl $1, %edi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 + (2 / 3)))
          # Emitting (1 + (2 / 3))
            # Emitting (2 / 3)
              # Emitting 2
              movl $2, %edi
              # Emitting 3
              movl $3, %esi
            movl %edi, %eax
            cltd
            idivl %esi
            movl %eax, %edi
            # Emitting 1
            movl $1, %esi
          addl %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(((1 + 2) / 3))
          # Emitting ((1 + 2) / 3)
            # Emitting (1 + 2)
              # Emitting 1
              movl $1, %esi
              # Emitting 2
              movl $2, %edi
            addl %edi, %esi
            # Emitting 3
            movl $3, %edi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 + (2 / 3)))
          # Emitting (1 + (2 / 3))
            # Emitting (2 / 3)
              # Emitting 2
              movl $2, %esi
              # Emitting 3
              movl $3, %edi
            movl %esi, %eax
            cltd
            idivl %edi
            movl %eax, %esi
            # Emitting 1
            movl $1, %edi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 / (2 + 3)))
          # Emitting (1 / (2 + 3))
            # Emitting (2 + 3)
              # Emitting 2
              movl $2, %edi
              # Emitting 3
              movl $3, %esi
            addl %esi, %edi
            # Emitting 1
            movl $1, %esi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
